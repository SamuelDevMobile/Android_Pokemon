package br.com.heiderlopes.pokemonwstemplatev2.presentation.scan

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import br.com.heiderlopes.pokemonwstemplatev2.R
import br.com.heiderlopes.pokemonwstemplatev2.databinding.ActivityScanBinding
import br.com.heiderlopes.pokemonwstemplatev2.presentation.BaseScanActivity
import br.com.heiderlopes.pokemonwstemplatev2.presentation.pokedex.PokedexActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ScanActivity : BaseScanActivity(), ZXingScannerView.ResultHandler {

    private val viewBinding by lazy { ActivityScanBinding.inflate(layoutInflater) }

    override val baseScannerView: ZXingScannerView?
        get() = viewBinding.mScannerView

    override fun onPermissionDenied() {
        viewBinding.permissions.containerPermission.visibility = View.VISIBLE
    }

    override fun onPermissionGranted() {
        viewBinding.permissions.containerPermission.visibility = View.GONE
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        viewBinding.permissions.btPermission.setOnClickListener {
            val intent = Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:$packageName")
            )
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            startActivity(intent)
        }
        super.requestPermission()
    }

    override fun handleResult(rawResult: Result?) {
        val pokemonNumber = rawResult?.text
        val intent = Intent(this, PokedexActivity::class.java)
        intent.putExtra("POKEMON", pokemonNumber)
        startActivity(intent)
        finish()
    }

    public override fun onResume() {
        super.onResume()
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            viewBinding.permissions.containerPermission.visibility =
                View.GONE
            viewBinding.mScannerView.setResultHandler(this)
            viewBinding.mScannerView.startCamera()
        } else {
            viewBinding.permissions.containerPermission.visibility =
                View.VISIBLE
        }
    }

}
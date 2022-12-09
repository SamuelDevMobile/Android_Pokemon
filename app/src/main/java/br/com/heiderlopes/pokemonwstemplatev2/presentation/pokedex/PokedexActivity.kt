package br.com.heiderlopes.pokemonwstemplatev2.presentation.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.heiderlopes.pokemonwstemplatev2.R
import br.com.heiderlopes.pokemonwstemplatev2.databinding.ActivityPokedexBinding
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.ViewState
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class PokedexActivity : AppCompatActivity() {

    private val viewBinding by lazy { ActivityPokedexBinding.inflate(layoutInflater) }
    private val viewModel: PokedexActivityViewModel by viewModel()
    private val picasso: Picasso by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        val number = intent.getStringExtra("POKEMON") ?: ""
        viewModel.getPokemon(number)
        registerObserver()
    }

    private fun registerObserver() {
        viewModel.pokemonResult.observe(this) { dados ->
            when(dados) {
                is ViewState.Success -> {
                    viewBinding.tvPokemonName.text = dados.data.name
                    picasso
                        .load("https://pokedexdx.herokuapp.com${dados.data.imageURL}")
                        .placeholder(R.drawable.logo_pokemon)
                        .into(viewBinding.ivPokemon)
                }
                is ViewState.Loading -> { }
                is ViewState.Failure -> {
                    Toast.makeText(this, dados.throwable.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}

package br.com.heiderlopes.pokemonwstemplatev2.presentation.pokedex

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.heiderlopes.pokemonwstemplatev2.R
import br.com.heiderlopes.pokemonwstemplatev2.databinding.ActivityPokedexBinding
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.ViewState
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class PokedexActivity : AppCompatActivity() {

    private val viewBinding by lazy { ActivityPokedexBinding.inflate(layoutInflater) }
    private val viewModel: PokedexActivityViewModel by viewModel()
    private val picasso: Picasso by inject()
    private lateinit var pokemon: Pokemon

    companion object {
        const val POKEMON_ID = "POKEMON"

        fun newInstance(context: Context, pokemonId: String?) {
            val intent = Intent(context, PokedexActivity::class.java)
            intent.putExtra(POKEMON_ID, pokemonId)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        val number = intent.getStringExtra(POKEMON_ID) ?: ""
        viewModel.getPokemon(number)
        registerObserver()
    }

    private fun registerObserver() {
        viewModel.pokemonResult.observe(this) {
            when(it) {
                is ViewState.Success -> {
                    viewBinding.tvPokemonName.text = it.data.name
                        picasso
                            .load("https://pokedexdx.herokuapp.com${it.data.imageURL}")
                            .placeholder(R.drawable.logo_pokemon)
                            .into(viewBinding.ivPokemon)
                }
                is ViewState.Loading -> { }
                is ViewState.Failure -> {
                    Toast.makeText(this, it.throwable.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}

package br.com.heiderlopes.pokemonwstemplatev2.presentation.listpokemons

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.heiderlopes.pokemonwstemplatev2.databinding.ActivityListPokemonsBinding
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.Pokemon
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.ViewState
import br.com.heiderlopes.pokemonwstemplatev2.presentation.formpokemon.FormPokemonActivity
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ListPokemonsActivity : AppCompatActivity() {

    private val listPokemonsViewModel: ListPokemonsViewModel by viewModel()
    private val picasso: Picasso by inject()
    private val viewBinding by lazy { ActivityListPokemonsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        listPokemonsViewModel.getPokemons()
        registerObserver()
    }

    private fun registerObserver() {
        listPokemonsViewModel.pokemonResult.observe(this) {
            when(it) {
                is ViewState.Success -> {
                    viewBinding.loading.containerLoading.visibility = View.GONE
                    configurationRecyclerView(it)
                }
                is ViewState.Loading -> {
                    viewBinding.loading.containerLoading.visibility = View.VISIBLE
                }
                is ViewState.Failure -> {
                    viewBinding.loading.containerLoading.visibility = View.GONE
                    Toast.makeText(this, it.throwable.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun configurationRecyclerView(listPokemons: ViewState.Success<List<Pokemon>>) {
        viewBinding.rvPokemons.adapter =
            ListPokemonsAdapter(listPokemons.data, picasso) {
                val intent = Intent(this, FormPokemonActivity::class.java)
                intent.putExtra("POKEMON", it.number)
                startActivity(intent)
            }
    }
}

package br.com.heiderlopes.pokemonwstemplatev2.presentation.listpokemons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.heiderlopes.pokemonwstemplatev2.R
import br.com.heiderlopes.pokemonwstemplatev2.domain.model.ViewState
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ListPokemonsActivity : AppCompatActivity() {

    private val listPokemonsViewModel: ListPokemonsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pokemons)
        listPokemonsViewModel.getPokemons()
        registerObservers()
    }

    private fun registerObservers() {
        listPokemonsViewModel.pokemonResult.observe(this) {
            when(it){
                is ViewState.Failure -> Log.d("POKEMON_API", "DEU RUIM")
                is ViewState.Success -> Log.d("POKEMON_API", it.data[0].name)
                is ViewState.Loading -> Log.d("POKEMON_API", "CARREGANDO")
            }
        }
    }
}

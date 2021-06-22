package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdapterViewPager(supportFragmentManager: FragmentManager): FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    var lista = ArrayList<String>()
    var listaFragmentos = ArrayList<Fragment>()

    fun addFragment(fragmento: Fragment, titulo:String ){
        lista.add(titulo)
        listaFragmentos.add(fragmento)
    }

    override fun getCount(): Int {
        return listaFragmentos.count()
    }

    override fun getItem(position: Int): Fragment {
        return listaFragmentos.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return lista.get(position)
    }
}
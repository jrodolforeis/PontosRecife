package com.example.pontosrecife

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import android.view.*
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pontosrecife.databinding.FragmentConfirmacaoBinding
import com.example.pontosrecife.databinding.FragmentFinalizacaoBinding

class FinalizacaoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFinalizacaoBinding>(
            inflater,
            R.layout.fragment_finalizacao, container, false
        )

        binding.buttonFinalizar.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_finalizacaoFragment_to_titleFragment2)
        }
        //setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }


}
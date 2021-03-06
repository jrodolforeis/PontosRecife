package com.example.pontosrecife

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pontosrecife.databinding.FragmentContatoBinding

class ContatoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentContatoBinding>(
            inflater,
            R.layout.fragment_contato, container, false
        )

        binding.button2.setOnClickListener {
            val nomeUsuario = binding.editTextTextPersonName.text.toString()
            val motivoContato = binding.editTextTextPersonName2.text.toString()
            val mensagemContato = binding.editTextTextMultiLine2.text.toString()
            val action = ContatoFragmentDirections.actionContatoFragment2ToConfirmacaoFragment(nomeUsuario, motivoContato, mensagemContato)
            findNavController().navigate(action)
        }
        setHasOptionsMenu(true)
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
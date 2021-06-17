package com.example.pontosrecife

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import android.view.*
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pontosrecife.databinding.FragmentConfirmacaoBinding

class ConfirmacaoFragment : Fragment() {

    private val args: ConfirmacaoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentConfirmacaoBinding>(
            inflater,
            R.layout.fragment_confirmacao, container, false
        )

        binding.textUsername.text = args.nomeUsuario
        binding.textMessage.text = args.mensagemContato
        binding.textTitle.text = args.tipoContato

        binding.buttonConfirmation.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_confirmacaoFragment_to_finalizacaoFragment)
            val text = "Mensagem enviada"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(activity, text, duration)
            toast.show()
        }

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
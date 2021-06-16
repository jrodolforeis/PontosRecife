package com.example.pontosrecife

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat.getDrawable
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pontosrecife.databinding.FragmentRandomBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RandomFragment : Fragment() {

    private lateinit var binding: FragmentRandomBinding

    private lateinit var viewModel: RandomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_random, container, false
        )

        viewModel = ViewModelProvider(this).get(RandomViewModel::class.java)

        binding.accessButton.setOnClickListener { onAccess() }
        binding.generateButton.setOnClickListener { onGenerate() }

        updateData()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun onGenerate() {
        viewModel.onGenerate()
        updateData()
    }

    private fun onAccess() {
        when(binding.wordText.text){
            "Marco Zero" -> {
                binding.accessButton.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_randomFragment_to_marcoCardFragment)
                }
                binding.wordImg.setImageDrawable(activity?.let { getDrawable(it.applicationContext,R.drawable.marco_zero) })
            }
            "Instituto Brennand" -> {
                binding.accessButton.setOnClickListener { view: View ->
                    view.findNavController().navigate(R.id.action_randomFragment_to_brennandCardFragment)
                }
                binding.wordImg.setImageDrawable(activity?.let { getDrawable(it.applicationContext,R.drawable.brennand) })
            }
            "Praia de Boa Viagem" -> {
                binding.accessButton.setOnClickListener { view: View ->
                    view.findNavController().navigate(R.id.action_randomFragment_to_praiaCardFragment)
                }
                binding.wordImg.setImageDrawable(activity?.let { getDrawable(it.applicationContext,R.drawable.praia_boa_viagem) })
            }
            "Rua da Moeda" -> {
                binding.accessButton.setOnClickListener { view: View ->
                    view.findNavController().navigate(R.id.action_randomFragment_to_moedaCardFragment)
                }
                binding.wordImg.setImageDrawable(activity?.let { getDrawable(it.applicationContext,R.drawable.rua_da_moeda) })
            }
            else -> {
                binding.accessButton.setOnClickListener { view: View ->
                    view.findNavController().navigate(R.id.action_randomFragment_to_centroCardFragment)
                }
                binding.wordImg.setImageDrawable(activity?.let { getDrawable(it.applicationContext,R.drawable.centro_artesanato) })
            }
        }
    }

    private fun updateData() {
        binding.wordText.text = viewModel.word
        onAccess()
    }

}
package com.image.deeplinking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.image.deeplinking.databinding.FragmentDeepLinkBinding

class DeepLinkFragment : Fragment() {

    private var binding:FragmentDeepLinkBinding ?= null
    //private val args : DeepLinkFragmentArgs by navArgs()
    private var productName =""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDeepLinkBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* productName = args.productName
        binding?.tvProductName?.text = productName*/

    }
}
package com.wyllyam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import org.koin.androidx.scope.fragmentScope
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.KoinScopeComponent
import org.koin.core.scope.Scope

abstract class BaseFragment(@LayoutRes private val layoutId: Int) : Fragment(), KoinScopeComponent  {

    override val scope: Scope by lazy { fragmentScope() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViewListeners()
        setupView(savedInstanceState)
    }

    protected open fun setupObservers() {}

    protected open fun setupViewListeners() {}

    protected open fun setupView(savedInstanceState: Bundle?) {}

    inline fun <reified T : Any> KoinScopeComponent.inject(
        qualifier: Qualifier? = null,
        fromScope: Boolean = false,
        mode: LazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED,
        noinline parameters: ParametersDefinition? = null
    ) = lazy(mode) { get<T>(qualifier, fromScope, parameters) }

    inline fun <reified T : Any> KoinScopeComponent.get(
        qualifier: Qualifier? = null,
        fromScope: Boolean = false,
        noinline parameters: ParametersDefinition? = null
    ): T = if (fromScope) {
        scope.get(qualifier, parameters)
    } else {
        getKoin().get(qualifier, parameters)
    }
}
package com.example.broadcastreceiver.ui.viewmodel

import androidx.lifecycle.*

class ItemViewModel : ViewModel() {
    private val mutableSelectedItem = MutableLiveData<String>()

    fun observeOnItem(lifecycleOwner: LifecycleOwner, item: Observer<String>) {
        mutableSelectedItem.observe(lifecycleOwner, item)
    }

    fun selectItem(item: String) {
        mutableSelectedItem.value = item
    }
}
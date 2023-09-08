/*
 * SPDX-FileCopyrightText: 2023 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.derpfest.flash.ext

import android.os.Looper
import androidx.lifecycle.MutableLiveData
import org.derpfest.flash.utils.livedatadelegate.NonNullableLiveDataDelegate
import org.derpfest.flash.utils.livedatadelegate.NullableLiveDataDelegate

/**
 * Set the value immediately if we're in the main thread, else it will post it to be set later.
 */
fun <T> MutableLiveData<T>.setOrPostValue(value: T) {
    if (Looper.getMainLooper().isCurrentThread) {
        this.value = value
    } else {
        postValue(value)
    }
}

inline fun <reified T> nonNullablePropertyDelegate(noinline initializer: () -> MutableLiveData<T>) =
    NonNullableLiveDataDelegate(initializer)

inline fun <reified T> nullablePropertyDelegate(noinline initializer: () -> MutableLiveData<T?>) =
    NullableLiveDataDelegate(initializer)

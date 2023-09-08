/*
 * SPDX-FileCopyrightText: 2023 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.derpfest.flash.utils.livedatadelegate

import androidx.lifecycle.MutableLiveData
import org.derpfest.flash.ext.setOrPostValue
import kotlin.reflect.KProperty

abstract class LiveDataDelegate<T>(private val initializer: () -> MutableLiveData<T>) {
    private var cached: MutableLiveData<T>? = null

    val value
        get() = cached ?: initializer().also { cached = it }

    abstract operator fun getValue(thisRef: Any?, property: KProperty<*>): T

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) =
        this.value.setOrPostValue(value)
}

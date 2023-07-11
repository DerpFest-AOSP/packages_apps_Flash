/*
 * SPDX-FileCopyrightText: 2022 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.derpfest.flash.camera

enum class CameraState {
    IDLE,
    TAKING_PHOTO,
    PRE_RECORDING_VIDEO,
    RECORDING_VIDEO,
    RECORDING_VIDEO_PAUSED,
}

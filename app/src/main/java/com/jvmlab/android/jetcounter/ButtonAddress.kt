package com.jvmlab.android.jetcounter

data class ButtonAddress(
    val screen: String,
    val id: String,
    val group: Int = 0
    ) {

    constructor(groupAddress: ButtonGroupAddress, id: String) :
            this(groupAddress.screen, id, groupAddress.group)
}


data class ButtonGroupAddress(
    val screen: String,
    val group: Int = 0
)
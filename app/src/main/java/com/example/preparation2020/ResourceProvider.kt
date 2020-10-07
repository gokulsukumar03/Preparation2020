package com.example.preparation2020

import android.content.Context

class ResourceProvider {
    fun getAppName(context: Context) = context.getString(R.string.app_name)
}
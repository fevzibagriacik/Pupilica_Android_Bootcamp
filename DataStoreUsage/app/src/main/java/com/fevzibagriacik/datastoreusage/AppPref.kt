package com.fevzibagriacik.datastoreusage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

class AppPref(var context:Context) {
    val Context.ds : DataStore<Preferences> by preferencesDataStore("data")
}
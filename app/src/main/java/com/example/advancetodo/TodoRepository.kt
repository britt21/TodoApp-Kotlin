package com.example.advancetodo

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject


@ActivityRetainedScoped
class TodoRepository @Inject constructor( localDataSource: LocalDataSource) {

    val local = localDataSource
}
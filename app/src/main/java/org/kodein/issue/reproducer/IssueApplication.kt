package org.kodein.issue.reproducer

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.with

class IssueApplication : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(androidXModule(this@IssueApplication))

        constant("author") with "Romain Boisselle"
        constant("description") with "Trying to reproduce issue #236 : closestKodein() in AndroidX AppCompatActivity throws NullPointerException"
    }

    override fun onCreate() {
        super.onCreate()
        val k = kodein
        println(k)
    }

}
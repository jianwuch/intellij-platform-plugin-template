package other.fragment.layout

fun mvvmFragmentXml(
    packageName: String,
    activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:tools="http://schemas.android.com/tools"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${activityClass}Fragment">
        
        
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""
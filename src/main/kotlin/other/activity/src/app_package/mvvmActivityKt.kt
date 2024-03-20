package other.activity.src.app_package


fun mvvmActivityKt(
    applicationPackage: String?,
    activityClass: String,
    layoutName: String,
    packageName: String
) = """
package ${packageName}

import android.os.Bundle
import ${applicationPackage}.R
import ${applicationPackage}.databinding.Activity${activityClass}Binding
import com.duiud.bobo.framework.activity.ViewModelActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ${activityClass}Activity : ViewModelActivity<${activityClass}VM, Activity${activityClass}Binding>() {
    override fun getLayoutId() = R.layout.${layoutName}
}
"""

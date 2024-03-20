package other.fragmentDialog.app_package


fun mvvmDialogFragmentKt(
    applicationPackage: String?,
    activityClass: String,
    layoutName: String,
    packageName: String,
    needVM: Boolean
): String {
    val vmClassName = if (needVM) {
        "${activityClass}VM"
    } else {
        "BaseViewModel"
    }
    return """
package ${packageName}

import android.os.Bundle
import android.view.View
import ${applicationPackage}.R
import ${applicationPackage}.databinding.Dialog${activityClass}Binding
import com.duiud.bobo.framework.viewmodel.BaseViewModel
import com.duiud.bobo.framework.fragment.ViewModelDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ${activityClass}Dialog : ViewModelDialog<${vmClassName}, Dialog${activityClass}Binding>() {
    override fun getLayoutId() = R.layout.${layoutName}
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
"""
}

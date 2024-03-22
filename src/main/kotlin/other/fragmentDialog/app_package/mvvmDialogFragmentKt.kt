package other.fragmentDialog.app_package


fun mvvmDialogFragmentKt(
    applicationPackage: String?,
    dialogName: String,
    layoutName: String,
    packageName: String,
    needVM: Boolean
): String {
    val vmClassName = if (needVM) {
        "${dialogName}VM"
    } else {
        "BaseViewModel"
    }

    val dialogFullClassName = "${dialogName}Dialog"
    val bindingFullClassName = "Dialog${dialogName}Binding"
    return """
package ${packageName}

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import ${applicationPackage}.R
import ${applicationPackage}.databinding.Dialog${dialogName}Binding
import com.duiud.bobo.framework.viewmodel.BaseViewModel
import com.duiud.bobo.framework.fragment.ViewModelDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ${dialogFullClassName} : ViewModelDialog<${vmClassName}, ${bindingFullClassName}>() {
    companion object {
        private const val TAG = "${dialogFullClassName}"
        fun show(fragmentManager: FragmentManager): ${dialogFullClassName} {
            val args = Bundle()
            val fragment = ${dialogFullClassName}()
            fragment.arguments = args
            fragment.show(fragmentManager, TAG)
            return fragment
        }
    }
    override fun getLayoutId() = R.layout.${layoutName}
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //todo Write business here 
    }
}
"""
}

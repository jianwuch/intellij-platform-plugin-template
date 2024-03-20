package other.fragment.app_package


fun mvvmFragmentKt(
    applicationPackage: String?,
    activityClass: String,
    layoutName: String,
    packageName: String
) = """
package ${packageName}

import android.os.Bundle
import android.view.View
import ${applicationPackage}.R
import ${applicationPackage}.databinding.Fragment${activityClass}Binding
import com.duiud.bobo.framework.fragment.ViewModelFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ${activityClass}Fragment : ViewModelFragment<${activityClass}VM, Fragment${activityClass}Binding>() {
    override fun getLayoutId() = R.layout.${layoutName}
    
    override fun onLazyLoad() {}
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
"""

package other.fragment.app_package


fun mvvmFragmentKt(
    applicationPackage: String?,
    fragmentName: String,
    layoutName: String,
    packageName: String
): String {
    val fullClassName = "${fragmentName}Fragment"
    val vmFullName = "${fragmentName}VM"
    val bindingFullClassName = "Fragment${fragmentName}Binding"

    return """
package ${packageName}

import android.os.Bundle
import android.view.View
import ${applicationPackage}.R
import ${applicationPackage}.databinding.${bindingFullClassName}
import com.duiud.bobo.framework.fragment.ViewModelFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ${fullClassName} : ViewModelFragment<${vmFullName}, ${bindingFullClassName}>() {
    companion object {
        fun newInstance(): ${fullClassName} {
            val args = Bundle()
            val fragment = ${fullClassName}()
            fragment.arguments = args
            return fragment
        }
    }
    override fun getLayoutId() = R.layout.${layoutName}
    
    override fun onLazyLoad() {
    //TODO loadData--httpData/DBData
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO init
    }
}
"""
}

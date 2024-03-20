package other.activity.src.app_package

fun mvvmViewModel(
    packageName: String,
    activityClass: String
) = """
package ${packageName}

import com.duiud.bobo.framework.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ${activityClass}VM @Inject constructor(): BaseViewModel() {
}
"""

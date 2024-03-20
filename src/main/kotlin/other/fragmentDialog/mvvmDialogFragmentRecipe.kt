package other.fragmentDialog

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.activity.src.app_package.mvvmViewModel
import other.fragment.app_package.mvvmFragmentKt
import other.fragment.layout.mvvmFragmentXml
import other.fragmentDialog.app_package.mvvmDialogFragmentKt
import other.fragmentDialog.layout.mvvmDialogFragmentXml


fun RecipeExecutor.mvvmDialogFragmentRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String,
    needVM: Boolean
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
//    generateManifest(
//            moduleData = moduleData,
//            activityClass = "${activityClass}Activity",
//            activityTitle = activityClass,
//            packageName = packageName,
//            isLauncher = false,
//            hasNoActionBar = false,
//            generateActivityTitle = true,
//            requireTheme = false,
//            useMaterial2 = false
//    )

    val mvvmFragment =
        mvvmDialogFragmentKt(
            projectData.applicationPackage,
            activityClass,
            layoutName,
            packageName,
            needVM
        )
    // 保存Dialog
    save(mvvmFragment, srcOut.resolve("${activityClass}Dialog.${ktOrJavaExt}"))
    // 保存xml
    save(
        mvvmDialogFragmentXml(packageName, activityClass),
        resOut.resolve("layout/${layoutName}.xml")
    )
    if (needVM) {
        // 保存viewmodel
        save(
            mvvmViewModel(packageName, activityClass),
            srcOut.resolve("vm/${activityClass}VM.${ktOrJavaExt}")
        )
    }
    /*    // 保存repository
        save(
            mvvmRepository(packageName, activityClass),
            srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}")
        )*/
}

package other.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.activity.res.layout.mvvmActivityXml
import other.activity.src.app_package.mvvmActivityKt
import other.activity.src.app_package.mvvmViewModel
import other.fragment.app_package.mvvmFragmentKt
import other.fragment.layout.mvvmFragmentXml


fun RecipeExecutor.mvvmFragmentRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String
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
        mvvmFragmentKt(projectData.applicationPackage, activityClass, layoutName, packageName)
    // 保存Fragment
    save(mvvmFragment, srcOut.resolve("${activityClass}Fragment.${ktOrJavaExt}"))
    // 保存xml
    save(mvvmFragmentXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
    // 保存viewmodel
    save(
        mvvmViewModel(packageName, activityClass),
        srcOut.resolve("vm/${activityClass}VM.${ktOrJavaExt}")
    )
/*    // 保存repository
    save(
        mvvmRepository(packageName, activityClass),
        srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}")
    )*/
}

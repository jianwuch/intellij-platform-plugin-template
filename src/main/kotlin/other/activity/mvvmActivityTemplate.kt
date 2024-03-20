package other.mvvm.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.activity.mvvmActivityRecipe
import java.util.Locale


val mvvmActivityTemplate
    get() = template {
//        revision = 1
        name = "Bobo MVVM Activity"
        description = "BoBo MVVM框架的Activity"
        minApi = MIN_API
//        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        lateinit var layoutName: StringParameter

        val activityClass = stringParameter {
            name = "Activity Name"
            default = "Main"
            help = "只输入名字，不要包含Activity"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(activityClass.value.cameToUnderlineCase())}" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(activityClass),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvvmActivityRecipe(
                data as ModuleTemplateData,
                activityClass.value,
                layoutName.value,
                packageName.value
            )
        }
    }
fun String.underlineToCamelCase(): String {
    val str = this.trim()
    if (str.isEmpty()) return ""
    return str.split("_").joinToString("") {
        if (it[0] in 'a'..'z') it[0] - 32 + it.substring(1) else it
    }
}

// 驼峰转下划线
fun String.cameToUnderlineCase(): String {
    val str = this.trim()
    if (str.isEmpty()) return ""
    val list = mutableListOf<String>()
    var i = 1
    var j = 0
    while (i < str.length) {
        if (str[i] in 'A'..'Z') {
            list.add(str.substring(j, i))
            j = i
        }
        i ++
    }
    list.add(str.substring(j))
    return list.joinToString("_") { it.lowercase(Locale.getDefault()) }
}

val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.duiud.bobo"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }

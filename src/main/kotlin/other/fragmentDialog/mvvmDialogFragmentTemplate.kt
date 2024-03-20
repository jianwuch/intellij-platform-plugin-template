package other.fragmentDialog

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.activity.mvvmActivityRecipe
import java.util.Locale


val mvvmDialogFragmentTemplate
    get() = template {
//        revision = 1
        name = "Bobo MVVM DialogFragment"
        description = "BoBo MVVM框架的DialogFragment"
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
            name = "Dialog Name(不要包含Dialog)"
            default = "Main"
            help = "只输入名字，不要包含Dialog"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "dialog_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "dialog_${activityClass.value.cameToUnderlineCase()}" }
        }

        val packageName = defaultPackageNameParameter

        val needVM = booleanParameter {
            name = "是否要生成ViewModel"
            default = true
        }
        widgets(
            TextFieldWidget(activityClass),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName),
            CheckBoxWidget(needVM)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvvmDialogFragmentRecipe(
                data as ModuleTemplateData,
                activityClass.value,
                layoutName.value,
                packageName.value,
                needVM.value
            )
        }
    }


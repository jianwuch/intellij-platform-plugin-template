package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.fragment.mvvmFragmentTemplate
import other.fragmentDialog.mvvmDialogFragmentTemplate
import other.mvvm.activity.mvvmActivityTemplate

class WizardTemplateProviderImpl: WizardTemplateProvider() {
    override fun getTemplates(): List<Template>  = listOf(

        // activity的模板
        mvvmActivityTemplate,
        // fragment的模板
        mvvmFragmentTemplate,
        //FragmentDialog
        mvvmDialogFragmentTemplate
    )

}
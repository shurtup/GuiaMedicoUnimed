package com.example.gabrielsantiago.guiamedicoandroidcaruaru.wizardpager.model;

/**
 * Created by gabriel.santiago on 12/11/2015.
 */
import android.content.Context;

public class GuiaMedicoWizardModel extends AbstractWizardModel {
    public GuiaMedicoWizardModel(Context context) {
        super(context);
    }

    @Override
    protected PageList onNewRootPageList() {
        return new PageList(
                new Specialties(this, "Escolha a especialidade")
                        .addBranch("Urologia",
                                new SingleFixedChoicePage(this, "Escolha o médico")
                                        .setChoices("Daivid Paulo", "Rafael Guinho", "Kevin Allen", "Thiago Marques", "Fabio Rezende")
                                        .setRequired(true),

                                new MultipleFixedChoicePage(this, "Escolha o local de atendimento")
                                        .setChoices("Mauricio de Nassau", "Salgado", "Bairro Universitario", "Panorama",
                                                "Nova Caruaru", "Indianópolis")
                                /*,

                                new Specialties(this, "Cardiologia")
                                        .addBranch("Yes",
                                                new SingleFixedChoicePage(this, "Toast time")
                                                        .setChoices("30 seconds", "1 minute",
                                                                "2 minutes"))
                                        .addBranch("No")
                                        .setValue("No")
                                */
                        )

                        .addBranch("Cardiologia",
                                new SingleFixedChoicePage(this, "Salad type")
                                        .setChoices("Greek", "Caesar")
                                        .setRequired(true),

                                new SingleFixedChoicePage(this, "Dressing")
                                        .setChoices("No dressing", "Balsamic", "Oil & vinegar",
                                                "Thousand Island", "Italian")
                                        .setValue("No dressing")
                        )
                        .addBranch("Fonodiologia",
                                new SingleFixedChoicePage(this, "Escolha o Medico")
                                        .setChoices("Rodolfo", "Luciano")
                                        .setRequired(true),

                                new SingleFixedChoicePage(this, "Dressing")
                                        .setChoices("No dressing", "Balsamic", "Oil & vinegar",
                                                "Thousand Island", "Italian")
                                        .setValue("No dressing")
                        )

                        .setRequired(true),

                new CustomerInfoPage(this, "Suas Informações")
                        .setRequired(true)
        );
    }
}

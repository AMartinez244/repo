
package com.cheques.models;

import java.io.Serializable;
import java.util.List;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;


public class Menu implements Serializable {

    private MenuModel model;

    public Menu(List<ModulosModel> modulos) {
        model = new DefaultMenuModel();
        DefaultMenuItem item = null;

        for (ModulosModel modulo : modulos) {
            item = new DefaultMenuItem(modulo.getDescripcion());
            item.setIcon(modulo.getIconame());
            item.setUrl(modulo.getUrl());
            model.addElement(item);
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
}

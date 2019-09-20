package com.maynoralvarez.menegedbeans;

import com.maynoralvarez.Detallecotizacion;
import com.maynoralvarez.menegedbeans.util.JsfUtil;
import com.maynoralvarez.menegedbeans.util.JsfUtil.PersistAction;
import com.maynoralvarez.sessionsbeans.DetallecotizacionFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("detallecotizacionController")
@SessionScoped
public class DetallecotizacionController implements Serializable {

    @EJB
    private com.maynoralvarez.sessionsbeans.DetallecotizacionFacadeLocal ejbFacade;
    private List<Detallecotizacion> items = null;
    private Detallecotizacion selected;

    public DetallecotizacionController() {
    }

    public Detallecotizacion getSelected() {
        return selected;
    }

    public void setSelected(Detallecotizacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DetallecotizacionFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Detallecotizacion prepareCreate() {
        selected = new Detallecotizacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DetallecotizacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DetallecotizacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DetallecotizacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Detallecotizacion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Detallecotizacion getDetallecotizacion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Detallecotizacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Detallecotizacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Detallecotizacion.class)
    public static class DetallecotizacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DetallecotizacionController controller = (DetallecotizacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "detallecotizacionController");
            return controller.getDetallecotizacion(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Detallecotizacion) {
                Detallecotizacion o = (Detallecotizacion) object;
                return getStringKey(o.getIddetallecotizacion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Detallecotizacion.class.getName()});
                return null;
            }
        }

    }

}

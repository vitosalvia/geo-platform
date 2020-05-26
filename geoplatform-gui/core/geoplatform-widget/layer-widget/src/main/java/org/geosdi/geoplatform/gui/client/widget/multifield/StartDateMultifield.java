package org.geosdi.geoplatform.gui.client.widget.multifield;

import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Validator;
import org.geosdi.geoplatform.gui.client.i18n.LayerModuleConstants;
import org.geosdi.geoplatform.gui.client.i18n.LayerModuleMessages;

import java.util.Date;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
public class StartDateMultifield extends TimePeriodDateMultifield {

    public StartDateMultifield() {
        super();
    }

    @Override
    protected Validator addValidator() {
        return new Validator() {
            @Override
            public String validate(Field<?> field, String value) {
                return validateDate() && getDate().before(limitDate) ? LayerModuleMessages.INSTANCE.LayerTimeFilterWidget_lowerLimitDate(limitDate.toString()) : null;
            }
        };
    }

    @Override
    protected String dateTooltip() {
        return LayerModuleConstants.INSTANCE.LayerTimeFilterWidget_startDateTooltipText();
    }

    @Override
    protected String hourTooltip() {
        return LayerModuleConstants.INSTANCE.LayerTimeFilterWidget_startHourTooltipText();
    }

    @Override
    protected String minuteTooltip() {
        return LayerModuleConstants.INSTANCE.LayerTimeFilterWidget_startMinuteTooltipText();
    }

    @Override
    protected String fieldLabel() {
        return LayerModuleConstants.INSTANCE.LayerTimeFilterWidget_multidatesFromText();
    }

    @Override
    public void bindDate(Date dateFrom, Date dateTo) {
        super.bindDate(dateFrom, dateTo);
        this.limitDate = dateFrom;
    }

    protected void buildHours(Date dateWithZeroTime) {
        if (date.getTime() == dateWithZeroTime.getTime()) {
            this.hourField.setMinValue(this.limitDate.getHours());
        }
        if (this.date.getTime() != dateWithZeroTime.getTime()) {
            this.hourField.setMinValue(0);
            this.minuteField.setMinValue(0);
        }
    }

    protected void buildMinutes(Date dateWithZeroTime, Date time) {
        if (date.getTime() == dateWithZeroTime.getTime() && limitDate.getHours() == time.getHours()) {
            this.minuteField.setMinValue(limitDate.getMinutes());
        } else {
            this.minuteField.setMinValue(0);
        }

    }

    @Override
    protected void setMaxMinValue() {
        this.hourField.setMaxValue(23);
        this.minuteField.setMaxValue(59);
    }

}

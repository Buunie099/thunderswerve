package frc.lib;

import java.util.function.DoubleConsumer;

public class ThunderMotorWrapper {
    DoubleConsumer m_setMotorVoltage;

    public ThunderMotorWrapper(DoubleConsumer setMotorVoltage) {
        m_setMotorVoltage = setMotorVoltage;
    }

    public void setVoltage(double voltage) {
        m_setMotorVoltage.accept(voltage);
    }
}

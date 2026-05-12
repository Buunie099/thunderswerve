package frc.lib;

import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecondPerSecond;

import edu.wpi.first.units.AngularVelocityUnit;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;

public class ThunderMotorSimulation {
    AngularVelocity m_velocity = RadiansPerSecond.of(0);
    AngularAcceleration m_acceleration = RadiansPerSecondPerSecond.of(0);

    AngularVelocity m_maximumVelocity;
    AngularAcceleration m_maximumAcceleration;

    public ThunderMotorSimulation(AngularVelocity maximumVelocity, AngularAcceleration maximumAcceleration) {
        m_maximumVelocity = maximumVelocity;
        m_maximumAcceleration = maximumAcceleration;
    }

    public void setVoltage(double voltage) {
        double percent = voltage / ThunderConstants.optimalVoltage.magnitude();
        AngularVelocityUnit velUnit = m_velocity.baseUnit();
        AngularVelocityUnit maxVelUnit = m_maximumVelocity.baseUnit();

        if (velUnit != maxVelUnit) {
            return;
        }

        double currentPercent = m_velocity.div(m_maximumVelocity).magnitude();

        double newPercent = (percent + currentPercent) / 2d;

        m_velocity = velUnit.of(newPercent * m_maximumVelocity.magnitude());
    }
}

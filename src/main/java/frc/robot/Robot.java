package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  private Joystick m_stick = new Joystick(0);
  private TalonFX mLeftMaster = new TalonFX(0);
  private TalonFX mRightMaster = new TalonFX(1);

  public Robot() {
    mLeftMaster.setInverted(true);
    mRightMaster.follow(mLeftMaster);
    mRightMaster.setInverted(false);
    mLeftMaster.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);
    mLeftMaster.setSensorPhase(true);
    mLeftMaster.config_kP(0, 0.00025);
    mLeftMaster.config_kI(0, 0.0);
    mLeftMaster.config_kD(0, 0.003);

  }

  @Override
  public void robotInit() {
  }
  @Override
  public void autonomousInit() {
  }
  @Override
  public void autonomousPeriodic() {
  }
  @Override
  public void disabledInit() {
  }
  @Override
  public void disabledPeriodic() {
  }
  @Override
  public void teleopInit() {
  }
  @Override
  public void teleopPeriodic() {
    if (m_stick.getRawButton(4)) {
      //mLeftMaster.set(ControlMode.Velocity, 1000);
    }
    mLeftMaster.set(ControlMode.PercentOutput, m_stick.getRawAxis(1)); 
    SmartDashboard.putNumber("flywheel ticks/100ms", mLeftMaster.getSelectedSensorPosition(0));
  }

  /**
   * Runs during test mode.
   */
  @Override
  public void testInit() {
  }
  @Override
  public void testPeriodic() {
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LeftArmSubsystem extends SubsystemBase {

    VictorSPX leftArm = new VictorSPX(LEFT_ARM_VICTOR_PORT);

    private double currentLeftArmSpeed = 0.0;

  /** Creates a new ArmSubsystem. */
  public LeftArmSubsystem() {
        leftArm.setNeutralMode(NeutralMode.Brake);
  }

  public void moveMotor(double speed, VictorSPX victor){
    victor.set(ControlMode.PercentOutput, speed);
  }

  public void setLeftArm(double speed){
    moveMotor(speed, leftArm);
    currentLeftArmSpeed = speed;
  }

  public void invertLeftArm(){
    setLeftArm(-currentLeftArmSpeed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

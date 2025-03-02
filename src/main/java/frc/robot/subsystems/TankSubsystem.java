// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankSubsystem extends SubsystemBase {

 boolean turboEnabled = false;
 VictorSPX leftVictor = new VictorSPX(LEFT_DRIVE_ID);
 VictorSPX rightVictor = new VictorSPX(RIGHT_DRIVE_ID);
//  VictorSPX backLeftVictor = new VictorSPX(FRONT_RIGHT_VICTOR_PORT);
//  VictorSPX backRightVictor = new VictorSPX(BACK_RIGHT_VICTOR_PORT);

  /** Creates a new TankSubsystem. */
  public TankSubsystem() {
    leftVictor.setInverted(true);
  }

  public void moveMotor(double speed, VictorSPX victor){
      victor.set(ControlMode.PercentOutput, speed);
  }
  public void arcadeDrive(double Y, double X, boolean turbo){

    if(turbo == false){
        moveMotor((Y + X) * Constants.DRIVE_SPEED,leftVictor);
        // moveMotor(Y - X,backLeftVictor);
        moveMotor((Y - X) * Constants.DRIVE_SPEED,rightVictor);
        // moveMotor(Y + X, backRightVictor);
    } else if(turbo == true){
        moveMotor((Y + X) * Constants.TURBO_SPEED,leftVictor);
        // moveMotor(Y - X,backLeftVictor);
        moveMotor((Y - X) * Constants.TURBO_SPEED,rightVictor);
        // moveMotor(Y + X, backRightVictor);
    }
  }

  public void toggleTurbo(){
    turboEnabled = !turboEnabled;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}

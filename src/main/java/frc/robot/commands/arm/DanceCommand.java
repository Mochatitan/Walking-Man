// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arm;

import java.util.Timer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LeftArmSubsystem;
import frc.robot.subsystems.RightArmSubsystem;

public class DanceCommand extends Command {

  private final LeftArmSubsystem leftArmSubsystem;
  private final RightArmSubsystem rightArmSubsystem;

  private long goalTime;

  
  /** Creates a new RightArmCommand. */
  public DanceCommand(LeftArmSubsystem k_leftArmSubsystem, RightArmSubsystem k_rightArmSubsystem) {
    this.leftArmSubsystem = k_leftArmSubsystem;
    this.rightArmSubsystem = k_rightArmSubsystem;
    addRequirements(leftArmSubsystem, rightArmSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    rightArmSubsystem.setRightArm(Constants.DANCE_MAX_RIGHT_ARM_SPEED);
    leftArmSubsystem.setLeftArm(Constants.DANCE_MAX_LEFT_ARM_SPEED);
    goalTime = System.currentTimeMillis() + Constants.ARM_MOVE_TIME_MS;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(System.currentTimeMillis() >= goalTime){
      rightArmSubsystem.invertRightArm();
      leftArmSubsystem.invertLeftArm();
      goalTime = System.currentTimeMillis() + Constants.ARM_MOVE_TIME_MS;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    rightArmSubsystem.setRightArm(0);
    leftArmSubsystem.setLeftArm(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

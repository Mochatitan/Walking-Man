// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.RightArmSubsystem;

public class RightArmCommand extends Command {

  private final RightArmSubsystem rightArmSubsystem;
  private double direction = 1;

  /** Creates a new RightArmCommand. */
  public RightArmCommand(RightArmSubsystem k_rightArmSubsystem, double direction) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.rightArmSubsystem = k_rightArmSubsystem;
    this.direction = direction;
    addRequirements(rightArmSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    rightArmSubsystem.setRightArm(Constants.MAX_ARM_SPEED_UP * this.direction);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    rightArmSubsystem.setRightArm(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

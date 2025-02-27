package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends Command {
    private final IntakeSubsystem m_intakeSubsystem;

    //constructor
    public IntakeCommand(IntakeSubsystem m_intakeSubsystem) {
        this.m_intakeSubsystem = m_intakeSubsystem;

        addRequirements(m_intakeSubsystem);
    }

    @Override
    public void execute() {
        m_intakeSubsystem.drive(Constants.subsystems.intake.INTAKE_SPEED);
    }

    /**
     * This function ensures when the action is complete, the robot stops moving
     * 
     * @param interrupted
     */
    @Override
    public void end(boolean interrupted) {
        m_intakeSubsystem.drive(0.0);
    }
}

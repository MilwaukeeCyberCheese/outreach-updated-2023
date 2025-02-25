package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
    private final DriveSubsystem m_driveSubsystem;

    private final DoubleSupplier m_translationXSupplier;
    private double inputX;

    private final DoubleSupplier m_translationYSupplier;
    private double inputY;

    private final DoubleSupplier m_rotationSupplier;
    private double inputRot;

    //constructor
    public DriveCommand(DriveSubsystem m_driveSubsystem, DoubleSupplier translationXSupplier,
            DoubleSupplier translationYSupplier, DoubleSupplier rotationSupplier) {
        this.m_driveSubsystem = m_driveSubsystem;
        this.m_translationXSupplier = translationXSupplier;
        this.m_translationYSupplier = translationYSupplier;
        this.m_rotationSupplier = rotationSupplier;

        addRequirements(m_driveSubsystem);
    }

    @Override
    public void execute() {
        inputX = m_translationXSupplier.getAsDouble();
        inputY = m_translationYSupplier.getAsDouble();
        inputRot = m_rotationSupplier.getAsDouble();

        m_driveSubsystem.drive(new ChassisSpeeds(inputX, inputY, inputRot));
    }

    /**
     * This function ensures when the action is complete, the robot stops moving
     * 
     * @param interrupted
     */
    @Override
    public void end(boolean interrupted) {
        m_driveSubsystem.drive(new ChassisSpeeds(0.0, 0.0, 0.0));
    }
}
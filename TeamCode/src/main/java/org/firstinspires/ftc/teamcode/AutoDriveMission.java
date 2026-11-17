package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;


//Quickstart ufficiale (SampleMecanumDrive e TrajectorySequence).
@Autonomous(name="AutoDriveMission", group="Cl-RoboCity")
public class AutoDriveMission extends LinearOpMode {

    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);


        // --- INIZIO TRAIETTORIA GENERATA ---
        Pose2d startPose = new Pose2d(-38.28, 33.09, Math.toRadians(90.0));
        drive.setPoseEstimate(startPose);

        TrajectorySequence missionSequence = drive.trajectorySequenceBuilder(startPose)
            .lineToLinearHeading(new Pose2d(57.61, 42.46, Math.toRadians(90.0)))
            .lineToLinearHeading(new Pose2d(42.26, 2.59, Math.toRadians(90.0)))
            .build();
        // --- FINE TRAIETTORIA GENERATA ---

        telemetry.addData("Status", "Traiettoria RoadRunner pronta.");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) return;

        drive.followTrajectorySequence(missionSequence);
    }
}

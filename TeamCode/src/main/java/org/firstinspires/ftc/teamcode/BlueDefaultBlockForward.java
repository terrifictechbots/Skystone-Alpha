//Terrfic Techbots FTC #14563
//12/15/2020
// Code title: BlueDefaultBlockForward
// Description: takes a block, puts it on the foundation, then parks under bridge in "forward position" (near neutral bridge)

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="BlueDefaultBlockForward", group="Linear Opmode")
public class BlueDefaultBlockForward extends LinearOpMode {

    /* Declare OpMode members. */
    TechbotHardware2         Terry   = new TechbotHardware2();
    private ElapsedTime     runtime = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 537.6 ;
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;
    static final double     DRIVE_GEAR_REDUCTION    = 1 ;
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
                                                      (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.6;
    static final double     TURN_SPEED              = 0.5;
    static final double SLIDEL_SPEED = 0.6;
    static final double SLIDER_SPEED = 0.6;
    static final double STOP = 0;

    @Override
    public void runOpMode() {

        Terry.init(hardwareMap);

        telemetry.addData("Status", "Resetting         // Send telemetry message to signify Terry waiting;\nEncoders");
        telemetry.update();

        Terry.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Terry.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Turn On RUN_TO_POSITION
        Terry.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0",  "Starting at %7d :%7d :%7d :%7d",
                          Terry.leftDrive.getCurrentPosition(),
                          Terry.rightDrive.getCurrentPosition(),
                          Terry.leftBackDrive.getCurrentPosition(),
                          Terry.rightBackDrive.getCurrentPosition());

        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        //open hand
        Terry.servoHand.setPosition(1);
        //drive towards quarry
        encoderDrive(DRIVE_SPEED/2,  -33,  -33, -33, -33);
        //close hand on block
        Terry.servoHand.setPosition(0.2);
        //wait 0.3 seconds
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.3)){
        }
        Terry.larm.setPower(0);
        //move the arm up at 0.4 speed for 0.7
        Terry.larm.setPower(0.4);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.7)) {
        }
        Terry.larm.setPower(0);
        encoderDrive(DRIVE_SPEED, 13, 13, 13,13);
        encoderDrive(SLIDER_SPEED,95, -95,-95,95);
        Terry.larm.setPower(0.4);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.5)) {
        }
        Terry.larm.setPower(0);
        encoderDrive(DRIVE_SPEED, -10, -10, -10, -10);
        // Terry is in front of foundation with stone hovering over
        Terry.servoHand.setPosition(1);
        // Block is let go and land on the foundation
        encoderDrive(DRIVE_SPEED, 30,30, 30,30); // Change all wheels to 1 for other parking spot
        Terry.servoHand.setPosition(0);
        Terry.larm.setPower(0.4);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < -0.3)) {
        }
        Terry.larm.setPower(0);
        encoderDrive(SLIDER_SPEED, -35, 35, 35, -35);
        encoderDrive(DRIVE_SPEED, -22, -22, -22, -22);
        encoderDrive(SLIDER_SPEED, -16, 16, 16, -16);
    }

    /*
     *  Method to preform a relative move, based on encoder counts.
     *  Encoders are not reset as the move is based on the current position.
     *  Move will stop if any of three conditions occur:
     *  1) Move gets to the desired position
     *  2) Move runs out of time
     *  3) Driver stops the opmode running.
     */
    public void encoderDrive(double speed,
                             double leftInches, double rightInches, double leftBackInches, double rightBackInches) {
        int newLeftTarget;
        int newRightTarget;
        int newLeftBackTarget;
        int newRightBackTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = Terry.leftDrive.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newRightTarget = Terry.rightDrive.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
            newLeftBackTarget = Terry.leftBackDrive.getCurrentPosition() + (int)(leftBackInches * COUNTS_PER_INCH);
            newRightBackTarget = Terry.rightBackDrive.getCurrentPosition() + (int)(rightBackInches * COUNTS_PER_INCH);


            Terry.leftDrive.setTargetPosition(newLeftTarget);
            Terry.rightDrive.setTargetPosition(newRightTarget);
            Terry.leftBackDrive.setTargetPosition(newLeftBackTarget);
           Terry.rightBackDrive.setTargetPosition(newRightBackTarget);


            // reset the timeout time and start motion.
            runtime.reset();
            Terry.leftDrive.setPower(Math.abs(speed));
            Terry.rightDrive.setPower(Math.abs(speed));
            Terry.leftBackDrive.setPower(Math.abs(speed));
            Terry.rightBackDrive.setPower(Math.abs(speed));



            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the Terry will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the Terry continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            //while (Terry.rightDrive.getCurrentPosition() < newRightTarget && opModeIsActive()) {
            while (opModeIsActive() && (Terry.rightDrive.isBusy() || Terry.leftBackDrive.isBusy() || Terry.leftDrive.isBusy() || Terry.leftBackDrive.isBusy()));

                // Display it for the driver.
                telemetry.addData("TargetPos",  "Running to %7d :%7d :%7d :%7d", newLeftTarget,  newRightTarget, newLeftBackTarget, newRightBackTarget);
                telemetry.addData("CurrentPos",  "Running at %7d :%7d :%7d :%7d",
                                            Terry.leftDrive.getCurrentPosition(),
                                            Terry.rightDrive.getCurrentPosition(),
                                            Terry.rightDrive.getCurrentPosition(),
                                            Terry.rightDrive.getCurrentPosition());

                telemetry.update();
            }
            Terry.leftDrive.setPower(0);
            Terry.rightDrive.setPower(0);
            Terry.leftBackDrive.setPower(0);
            Terry.rightBackDrive.setPower(0);

        Terry.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Terry.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Turn On RUN_TO_POSITION
        Terry.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        }
    }


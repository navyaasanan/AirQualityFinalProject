# Fixed (most) of the stuff associated with the project.

The only issue that is left is that there is no *Layout* folder under
`AirQualityFinalProject/app/src/main/res`.

The reason for this is that the *very first* problem was that there was a child git repository in the
wrong location. Adding the folder back in here manually would fix the issue,
allow for all of the files to compile, and would let everything run
as it should.
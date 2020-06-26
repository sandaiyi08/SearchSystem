import face_recognition
import sys


def face_check(face_img_path_to_check, face_location_to_check_str, known_face_img_path, known_face_location_str):
    known_face_location = eval(known_face_location_str)
    face_location_to_check = eval(face_location_to_check_str)
    # Known face image
    fr_known_face_img = face_recognition.load_image_file(known_face_img_path)
    fr_known_face_encodings = face_recognition.face_encodings(fr_known_face_img, known_face_locations=known_face_location, num_jitters=2)
    # Face image to check
    fr_face_img_to_check = face_recognition.load_image_file(face_img_path_to_check)
    fr_face_encoding_to_check = face_recognition.face_encodings(fr_face_img_to_check, known_face_locations=face_location_to_check, num_jitters=2)
    # Compare
    result = "Fail"
    if len(fr_known_face_encodings) > 0 and len(fr_face_encoding_to_check) > 0:
        for fr_known_face_encoding in fr_known_face_encodings:
            face_distance = face_recognition.face_distance(fr_known_face_encoding, fr_face_encoding_to_check)
            if face_recognition.face_distance(fr_known_face_encoding, fr_face_encoding_to_check) < 0.38:
                result = "OK"
                break
    print(result)


face_check(sys.argv[1], sys.argv[2], sys.argv[3], sys.argv[4])


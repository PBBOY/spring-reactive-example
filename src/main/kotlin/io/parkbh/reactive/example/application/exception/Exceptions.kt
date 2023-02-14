package io.parkbh.reactive.example.application.exception

import java.lang.IllegalStateException


class UserNotFoundException(message: String) : RuntimeException(message)
class UserExistsException(message: String) : IllegalStateException(message)
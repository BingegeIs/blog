package bingege.blog.component.admin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AdminServiceImpl(
    @Autowired val adminRepository: AdminRepository
) : AdminRepository by adminRepository {


}
package seoul.globalAdManagerPlatformByMtak.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdOwnerRepository extends JpaRepository<AdOwner, Long> {
    AdOwner findByNickname(String nickname);
}

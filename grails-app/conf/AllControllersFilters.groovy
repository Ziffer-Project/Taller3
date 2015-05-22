class AllControllersFilters {

	def filters = {
		adminControllerFilter(controller:'admin', action:'*', actionExclude:'index') {
			before = {
				if (session.authStatus.equals('logged')) {
					applicationContext.getBean("taller3.AdminController").create()
					// Show == Read
					applicationContext.getBean("taller3.AdminController").show()
					applicationContext.getBean("taller3.AdminController").update()
					applicationContext.getBean("taller3.AdminController").delete()
				} else {
					redirect(controller: 'admin', action: 'index')
					return false
				}

			}
		}

		fileControllerFilter(controller:'file', action:'*', actionExclude:'index') {
			before = {
				if (session.authStatus.equals('logged')) {
					applicationContext.getBean("taller3.AdminController").create()
					// Show == Read
					applicationContext.getBean("taller3.AdminController").show()
					applicationContext.getBean("taller3.AdminController").update()
					applicationContext.getBean("taller3.AdminController").delete()
				} else {
					redirect(controller: 'file', action: 'index')
					return false
				}

			}
		}

		forumControllerFilter(controller:'forum', action:'*', actionExclude:'index') {
			before = {
				if (session.authStatus.equals('logged')) {
					applicationContext.getBean("taller3.AdminController").create()
					// Show == Read
					applicationContext.getBean("taller3.AdminController").show()
					applicationContext.getBean("taller3.AdminController").update()
					applicationContext.getBean("taller3.AdminController").delete()
				} else {
					redirect(controller: 'forum', action: 'index')
					return false
				}

			}
		}

		postControllerFilter(controller:'post', action:'*', actionExclude:'index') {
			before = {
				if (session.authStatus.equals('logged')) {
					applicationContext.getBean("taller3.AdminController").create()
					// Show == Read
					applicationContext.getBean("taller3.AdminController").show()
					applicationContext.getBean("taller3.AdminController").update()
					applicationContext.getBean("taller3.AdminController").delete()
				} else {
					redirect(controller: 'post', action: 'index')
					return false
				}

			}
		}

		regularControllerFilter(controller:'regular', action:'*', actionExclude:'index') {
			before = {
				if (session.authStatus.equals('logged')) {
					applicationContext.getBean("taller3.AdminController").create()
					// Show == Read
					applicationContext.getBean("taller3.AdminController").show()
					applicationContext.getBean("taller3.AdminController").update()
					applicationContext.getBean("taller3.AdminController").delete()
				} else {
					redirect(controller: 'regular', action: 'index')
					return false
				}

			}
		}

		userControllerFilter(controller:'user', action:'*', actionExclude:'index') {
			before = {
				if (session.authStatus.equals('logged')) {
					applicationContext.getBean("taller3.AdminController").create()
					// Show == Read
					applicationContext.getBean("taller3.AdminController").show()
					applicationContext.getBean("taller3.AdminController").update()
					applicationContext.getBean("taller3.AdminController").delete()
				} else {
					redirect(controller: 'user', action: 'index')
					return false
				}

			}
		}
	}

}